
var requestOptions = {
	method: 'GET',
	redirect: 'follow'
  };
  
	  var $ = go.GraphObject.make;  // for conciseness in defining templates
  
  myDiagram =
	  $(go.Diagram, "myDiagramDiv",  // create a Diagram for the DIV HTML element
		  {
			  // allow double-click in background to create a new node
			  "clickCreatingTool.archetypeNodeData": { text: "Node", color: "white" },
  
			  // allow Ctrl-G to call groupSelection()
			  "commandHandler.archetypeGroupData": { text: "Group", isGroup: true, color: "blue" },
  
			  // enable undo & redo
			  "undoManager.isEnabled": true
		  });
  
  // Define the appearance and behavior for Nodes:
  
  // First, define the shared context menu for all Nodes, Links, and Groups.
  
  // To simplify this code we define a function for creating a context menu button:
  function makeButton(text, action, visiblePredicate) {
	  return $("ContextMenuButton",
		  $(go.TextBlock, text),
		  { click: action },
		  // don't bother with binding GraphObject.visible if there's no predicate
		  visiblePredicate ? new go.Binding("visible", "", function (o, e) { return o.diagram ? visiblePredicate(o, e) : false; }).ofObject() : {});
  }
  
  // a context menu is an Adornment with a bunch of buttons in them
  var partContextMenu =
	  $("ContextMenu",
		  makeButton("Properties",
			  function (e, obj) {  // OBJ is this Button
				  var contextmenu = obj.part;  // the Button is in the context menu Adornment
				  var part = contextmenu.adornedPart;  // the adornedPart is the Part that the context menu adorns
				  // now can do something with PART, or with its data, or with the Adornment (the context menu)
				  if (part instanceof go.Link) alert(linkInfo(part.data));
				  else if (part instanceof go.Group) alert(groupInfo(contextmenu));
				  else alert(nodeInfo(part.data));
			  }),
		  makeButton("Cut",
			  function (e, obj) { e.diagram.commandHandler.cutSelection(); },
			  function (o) { return o.diagram.commandHandler.canCutSelection(); }),
		  makeButton("Copy",
			  function (e, obj) { e.diagram.commandHandler.copySelection(); },
			  function (o) { return o.diagram.commandHandler.canCopySelection(); }),
		  makeButton("Paste",
			  function (e, obj) { e.diagram.commandHandler.pasteSelection(e.diagram.toolManager.contextMenuTool.mouseDownPoint); },
			  function (o) { return o.diagram.commandHandler.canPasteSelection(o.diagram.toolManager.contextMenuTool.mouseDownPoint); }),
		  makeButton("Delete",
			  function (e, obj) { e.diagram.commandHandler.deleteSelection(); },
			  function (o) { return o.diagram.commandHandler.canDeleteSelection(); }),
		  makeButton("Undo",
			  function (e, obj) { e.diagram.commandHandler.undo(); },
			  function (o) { return o.diagram.commandHandler.canUndo(); }),
		  makeButton("Redo",
			  function (e, obj) { e.diagram.commandHandler.redo(); },
			  function (o) { return o.diagram.commandHandler.canRedo(); }),
		  makeButton("Group",
			  function (e, obj) { e.diagram.commandHandler.groupSelection(); },
			  function (o) { return o.diagram.commandHandler.canGroupSelection(); }),
		  makeButton("Ungroup",
			  function (e, obj) { e.diagram.commandHandler.ungroupSelection(); },
			  function (o) { return o.diagram.commandHandler.canUngroupSelection(); })
	  );
  
  function nodeInfo(d) {  // Tooltip info for a node data object
	  var str = "Node " + d.key + ": " + d.text + "\n";
	  if (d.group)
		  str += "member of " + d.group;
	  else
		  str += "top-level node";
	  return str;
  }
  
  function showProperties(e, obj) {  // executed by ContextMenuButton
	var node = obj.part.adornedPart;
	var msg = "Context clicked: " + node.data.key + ". ";
	msg += "Selection includes:";
	myDiagram.selection.each(function(part) {
	  msg += " " + part.toString();
	});
	document.getElementById("myStatus").textContent = msg;
  }
  
  // These nodes have text surrounded by a rounded rectangle
  // whose fill color is bound to the node data.
  // The user can drag a node by dragging its TextBlock label.
  // Dragging from the Shape will start drawing a new link.
  
  function nodeClicked(e, obj) {  // executed by click and doubleclick handlers
	var evt = e.copy();
	var node = obj.part;
	var type = evt.clickCount === 2 ? "Double-Clicked: " : "Clicked: ";
	var msg = type + node.data.key + ". ";
	location.href = "/orgchart/position/details/"+node.data.key;
  }
  
  myDiagram.nodeTemplate =
	  $(go.Node, "Auto",
		  { locationSpot: go.Spot.Center },
		  {
			click: nodeClicked,
			doubleClick: nodeClicked,
			contextMenu:
			  $("ContextMenu",
				$("ContextMenuButton",
				  $(go.TextBlock, "Properties"),
				  { click: showProperties })
			  )
		  },
		  $(go.Shape, "RoundedRectangle",
			  {
				  fill: "white", // the default fill, if there is no data bound value
				  portId: "", cursor: "pointer",  // the Shape is the port, not the whole Node
				  // allow all kinds of links from and to this port
				  fromLinkable: true, fromLinkableSelfNode: true, fromLinkableDuplicates: true,
				  toLinkable: true, toLinkableSelfNode: true, toLinkableDuplicates: true
			  },
			  new go.Binding("fill", "color")),
		  $(go.TextBlock,
			  {
				  font: "bold 14px sans-serif",
				  stroke: '#333',
				  margin: 6,  // make some extra space for the shape around the text
				  isMultiline: false,  // don't allow newlines in text
				  editable: true  // allow in-place editing by user
			  },
			  new go.Binding("text", "text").makeTwoWay()),  // the label shows the node data's text
		  { // this tooltip Adornment is shared by all nodes
			  toolTip:
				  $("ToolTip",
					  $(go.TextBlock, { margin: 4 },  // the tooltip shows the result of calling nodeInfo(data)
						  new go.Binding("text", "", nodeInfo))
				  ),
			  // this context menu Adornment is shared by all nodes
			  contextMenu: partContextMenu
		  }
	  );
  
  // Define the appearance and behavior for Links:
  
  function linkInfo(d) {  // Tooltip info for a link data object
	  return "Link:\nfrom " + d.from + " to " + d.to;
  }
  
  // The link shape and arrowhead have their stroke brush data bound to the "color" property
  myDiagram.linkTemplate =
	  $(go.Link,
		  { toShortLength: 3, relinkableFrom: true, relinkableTo: true },  // allow the user to relink existing links
		  $(go.Shape,
			  { strokeWidth: 2 },
			  new go.Binding("stroke", "color")),
		  $(go.Shape,
			  { toArrow: "Standard", stroke: null },
			  new go.Binding("fill", "color")),
		  { // this tooltip Adornment is shared by all links
			  toolTip:
				  $("ToolTip",
					  $(go.TextBlock, { margin: 4 },  // the tooltip shows the result of calling linkInfo(data)
						  new go.Binding("text", "", linkInfo))
				  ),
			  // the same context menu Adornment is shared by all links
			  contextMenu: partContextMenu
		  }
	  );
  
  // Define the appearance and behavior for Groups:
  
  function groupInfo(adornment) {  // takes the tooltip or context menu, not a group node data object
	  var g = adornment.adornedPart;  // get the Group that the tooltip adorns
	  var mems = g.memberParts.count;
	  var links = 0;
	  g.memberParts.each(function (part) {
		  if (part instanceof go.Link) links++;
	  });
	  return "Group " + g.data.key + ": " + g.data.text + "\n" + mems + " members including " + links + " links";
  }
  
  // Groups consist of a title in the color given by the group node data
  // above a translucent gray rectangle surrounding the member parts
  myDiagram.groupTemplate =
	  $(go.Group, "Vertical",
		  {
			  selectionObjectName: "PANEL",  // selection handle goes around shape, not label
			  ungroupable: true  // enable Ctrl-Shift-G to ungroup a selected Group
		  },
		  $(go.TextBlock,
			  {
				  //alignment: go.Spot.Right,
				  font: "bold 19px sans-serif",
				  isMultiline: false,  // don't allow newlines in text
				  editable: true  // allow in-place editing by user
			  },
			  new go.Binding("text", "text").makeTwoWay(),
			  new go.Binding("stroke", "color")),
		  $(go.Panel, "Auto",
			  { name: "PANEL" },
			  $(go.Shape, "Rectangle",  // the rectangular shape around the members
				  {
					  fill: "rgba(128,128,128,0.2)", stroke: "gray", strokeWidth: 3,
					  portId: "", cursor: "pointer",  // the Shape is the port, not the whole Node
					  // allow all kinds of links from and to this port
					  fromLinkable: true, fromLinkableSelfNode: true, fromLinkableDuplicates: true,
					  toLinkable: true, toLinkableSelfNode: true, toLinkableDuplicates: true
				  }),
			  $(go.Placeholder, { margin: 10, background: "transparent" })  // represents where the members are
		  ),
		  { // this tooltip Adornment is shared by all groups
			  toolTip:
				  $("ToolTip",
					  $(go.TextBlock, { margin: 4 },
						  // bind to tooltip, not to Group.data, to allow access to Group properties
						  new go.Binding("text", "", groupInfo).ofObject())
				  ),
			  // the same context menu Adornment is shared by all groups
			  contextMenu: partContextMenu
		  }
	  );
  
  // Define the behavior for the Diagram background:
  
  function diagramInfo(model) {  // Tooltip info for the diagram's model
	  return "Model:\n" + model.nodeDataArray.length + " nodes, " + model.linkDataArray.length + " links";
  }
  
  // provide a tooltip for the background of the Diagram, when not over any Part
  myDiagram.toolTip =
	  $("ToolTip",
		  $(go.TextBlock, { margin: 4 },
			  new go.Binding("text", "", diagramInfo))
	  );
  
  // provide a context menu for the background of the Diagram, when not over any Part
  myDiagram.contextMenu =
	  $("ContextMenu",
		  makeButton("Paste",
			  function (e, obj) { e.diagram.commandHandler.pasteSelection(e.diagram.toolManager.contextMenuTool.mouseDownPoint); },
			  function (o) { return o.diagram.commandHandler.canPasteSelection(o.diagram.toolManager.contextMenuTool.mouseDownPoint); }),
		  makeButton("Undo",
			  function (e, obj) { e.diagram.commandHandler.undo(); },
			  function (o) { return o.diagram.commandHandler.canUndo(); }),
		  makeButton("Redo",
			  function (e, obj) { e.diagram.commandHandler.redo(); },
			  function (o) { return o.diagram.commandHandler.canRedo(); })
	  );
  
  // Create the Diagram's Model:
  var nodeDataArray = [
	  { key: 1, text: "Alpha", color: "lightblue" },
	  { key: 2, text: "Beta", color: "orange" },
	  { key: 3, text: "Gamma", color: "lightgreen", group: 5 },
	  { key: 4, text: "Delta", color: "pink", group: 5 },
	  { key: 5, text: "Epsilon", color: "green", isGroup: true }
  ];
  var linkDataArray = [
	  { from: 1, to: 2, color: "blue" },
	  { from: 3, to: 4, color: "green" },
	  { from: 3, to: 1, color: "purple" }
  ];
  
  
  
  
  function getNodeDataArray(tbl_position) {
	  return tbl_position.map(e => {
		  let tmp = {};
		  tmp["key"] = e.id;
		  tmp["text"] = e.name;
		  return tmp;
	  }
	  )
  }
  function getLinkDataArray(tbl_roles) {
	  let tmpPair = [];
	  tbl_roles.map(e => {
		  let tmp = [];
		  if(e.path!=null && e.path!=""){
			  var value=e.path;
			  value.split(",").forEach(e=>{
				  tmp.push(e)
			  });
		  }
		  
		  for (let i = 0; i < tmp.length - 1; i++) {
			  let tmpObj = {};
			  tmpObj["from"] = tmp[i];
			  tmpObj["to"] = tmp[i + 1];
			  tmpObj["color"] = "green";
			  tmpPair.push(tmpObj)
		  }
  
	  });
	  // start to filter
	  keys = ['from', 'to'];
	  filtered = tmpPair.filter(
		  (s => o => 
			  (k => !s.has(k) && s.add(k))
			  (keys.map(k => o[k]).join('|'))
		  )
		  (new Set)
	  );
  
	  return filtered;
  }
  
  //fetch("http://10.184.224.79:8080/api/getAllPositions/", requestOptions)
  //.then(response => response.json())
  //.then(result => {
  //	  var tbl_position=result;
  //	  fetch("http://10.184.224.79:8080/api/getAllStructures/", requestOptions)
  //	  .then(response => response.json())
  //	  .then(result => {
  //	  	  var tbl_roles=result;
  //	  	  console.log(tbl_roles);
  //	  	  myDiagram.model = new go.GraphLinksModel(getNodeDataArray(tbl_position), getLinkDataArray(tbl_roles));
  //	  	  
  //	  })
  //	  
  //	  
  //})
  //.catch(error => console.log('error', error));
  
  
  // temporary
  
  var tmpNodeDataArray= [
	  { key: "Engineering", text: "Engineering", color: "lightblue" },
	  { key: "Member Engineering", text: "Member Engineering", color: "orange" },
	  { key: "Technical Lead", text: "Technical Lead", color: "lightgreen"},
	  { key: "Product Manager", text: "Product Manager", color: "pink"},
	  { key: "Architect", text: "Architect", color: "green"},
	  { key: "SW Delivery Manager", text: "SW Delivery Manager", color: "green"},
	  { key: "DQA", text: "DQA", color: "green"},
	  { key: "SQM", text: "SQM", color: "green"},
	  { key: "Subject Matter Expert", text: "Subject Matter Expert", color: "green"},
	  { key: "Architect", text: "Architect", color: "green"},
	  { key: "Principal Consultant", text: "Principal Consultant", color: "green"},
	  { key: "Program Manager", text: "Program Manager", color: "green"},
	  { key: "Engineering Manager", text: "Engineering Manager", color: "green"},
	  
  ];
  function getTmpLinkDataArray(structures){
	  var temp=[];
	  // to reassign obj, remove id,departmentname & domain
	  var newStructure=structures.map(e=>{
		  let tmp={};
		  for(let i in e){
			  if(i!="id" && i!="departmentName" && i!="domain"){
				  tmp[i]=e[i];
			  }
		  }
		  return tmp;
	  });
	  
	  var tmpPair=[];
	  var arr=newStructure.map(e=>{
		  
		  let tmp=[];
		  for(let i in e){
			  if(e[i]!=null && e[i]!=undefined){
				  tmp.push(e[i]);
			  }
		  }
  
		  //
		  for (let i = 0; i < tmp.length - 1; i++) {
			  let tmpObj = {};
			  tmpObj["from"] = tmp[i];
			  tmpObj["to"] = tmp[i + 1];
			  tmpObj["color"] = "green";
			  tmpPair.push(tmpObj)
		  }
	  })
	  // to convert into new arr of obj
	  // obj: {from: ..., to: ..., color: ...}
	  let keys = ['from', 'to'];
	  let filtered = tmpPair.filter(
		  (s => o => 
			  (k => !s.has(k) && s.add(k))
			  (keys.map(k => o[k]).join('|'))
		  )
		  (new Set)
	  );
  
	  return filtered;
	  
  }
  function getTmpNodeDataArray(structures){
	var temp=[];
	// to reassign obj, remove id,departmentname & domain
	var newStructure=structures.map(e=>{
		let tmp={};
		for(let i in e){
			if(i!="id" && i!="departmentName" && i!="domain"){
				tmp[i]=e[i];
			}
		}
		return tmp;
	});
	
		var tmp=[];
	var arr=newStructure.map(e=>{
		
		for(let i in e){
			if(e[i]!=null && e[i]!=undefined){
				tmp.push(e[i]);
			}
		}

	})
	let filtered = [...new Set(tmp)];

	// to convert into arr of obj
	// { key: "Engineering", text: "Engineering", color: "lightblue" },
	let result=[];
	filtered.map(e=>{
		let tmp={};
		tmp["key"]=e;
		tmp["text"]=e;
		tmp["color"]="lightblue";
		if(tmp["key"]!="") result.push(tmp);
	})
	return result;
	
}
//   fetch("http://localhost:8080/api/getAllPositionDetails/", requestOptions)
//   .then(response => response.json())
//   .then(result => {
	// Member Engineering
	// domainRoles

//   })

  fetch("/orgchart/api/getAllStructures/", requestOptions)
  .then(response => response.json())
  .then(result => {
	  console.log(result);
	  let departmentName="";
	  let url=window.location.href.split("/");
	  departmentName=url[url.length-2];
	  let tmp=[];
	  result.forEach(e=>{
		  if(e.departmentName==departmentName){
			  tmp.push(e);
		  }
	  })
	  myDiagram.model = new go.GraphLinksModel(getTmpNodeDataArray(tmp), getTmpLinkDataArray(tmp));
  })
  
	
  
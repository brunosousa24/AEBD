var json = require('../Json/roles')

for (var j in json) {
  var table = document.getElementById("rolestab");
  var tr = document.createElement("tr");
  var td = document.createElement("td");
  
  for (var key in json[j]) {
    var txt = document.createTextNode(key);
    td.appendChild(txt);
    tr.appendChild(td);
  }
  table.appendChild(tr);
}

table, td {
    border: 1px solid black;
}
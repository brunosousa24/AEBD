const MEMCHART = document.getElementById("memoryChart");
//var json = require('./Json/cpu.json');
console.log(MEMCHART);
let memoryChart = new Chart(MEMCHART,{
	type: 'bar',
    data: {
      labels: ["Fixed Size","Variable Size","Database Buffers","Redo Buffers"],
      datasets: [
        {
          label: "Memory Storage",
          backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f","#c45850"],
          data: [8798312,314576792,511705088,3780608]
        }
      ]
    },
    options: {
      legend: { display: false },
      title: {
        display: true,
        text: 'Informação de Memory Storage'
      }
    }
});




<html><head><link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/><link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css"/><meta charset="UTF-8"/><title>TP - AEBD</title></head><body><div class="w3-container w3-blue-gray w3-center"><h1 class="w3-xxlarge"><b>Administração e Exploração de Bases de Dados</b></h1></div><div class="w3-container"><header class="w3-bar w3-blue-gray w3-round-large w3-padding w3-center"><a class="w3-bar-item w3-button w3-mobile w3-round-large" href="/">Home</a><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction()">CPU <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo"><a class="w3-bar-item w3-button" href="/app/cpu/default">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction2()">Sessions <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo2"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction3()">Users <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo3"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction4()">Memory Storage <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo4"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction5()">Tablespaces <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo5"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction6()">Datafiles <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo6"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction7()">SQL Commands <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo7"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div><div class="w3-dropdown-click"><button class="w3-button" onclick="myFunction8()">Roles <i class="fa fa-caret-down"></i></button><div class="w3-dropdown-content w3-bar-block w3-card" id="demo8"><a class="w3-bar-item w3-button" href="#">Link 1</a></div></div></header></div><h1>CPU</h1><canvas id="memoryChart" height="400" width="400"></canvas><script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script><script src="memoryChart.js"></script><div class="w3-container"><footer class="w3-container w3-blue-gray w3-bottommidlle w3-round-large"><address style="text-align:center;">Amostra em baixo layout.pug</address></footer></div></body></html>



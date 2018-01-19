const MEMCHART = document.getElementById("memoryChart");
console.log(MEMCHART);

var i, j, x = "";
var myValue = [];

$(function(){
  $.ajax({
             method: "GET", //rest Type
             dataType: 'json', //mispelled
             url: "http://localhost:5555/app/memstorage/json",
             async: false,
             contentType: "application/json; charset=utf-8",
             success: function (msg) {
               for (i in msg.items) {
                      myValue[i] = msg.items[i].value;
               }
                 console.log(msg);
             }
  });


let memoryChart = new Chart(MEMCHART,{
  type: 'horizontalBar',
    data: {
      labels: ["Fixed Size","Variable Size","Database Buffers","Redo Buffers"],
      datasets: [
        {
          label: "Memory Storage",
          backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f","#c45850"],
          data: myValue
        }
      ]
    },
    options: {
      scales: {
        xAxes: [{
            barPercentage: 0.4
        }],
        yAxes: [{
            barPercentage: 0.4
        }]
    },
      legend: { display: false },
      title: {
        display: true,
        text: 'Informação de Memory Storage'
      }

    }
});

});
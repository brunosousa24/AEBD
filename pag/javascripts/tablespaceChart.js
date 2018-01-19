const TBSPACECHART = document.getElementById("tbspaceChart");
//console.log(TBSPACECHART);

var i, j, x = "";
var myValue = [];
var myUsed = [];


$(function(){
  $.ajax({
             method: "GET", //rest Type
             dataType: 'json', //mispelled
             url: "http://localhost:5555/app/tablespaces/json",
             async: false,
             contentType: "application/json; charset=utf-8",
             success: function (msg) {
              console.log(msg)
               for (i in msg.items) {
                      myValue[i] = msg.items[i].free;
                      myUsed[i] = msg.items[i].used;
               }

                 console.log("MY value:"+myValue);
              
                 console.log("MY used:"+myUsed);
             }
  });


let tbspaceChart = new Chart(TBSPACECHART,{
  type: 'bar',
    data: {
      labels: ["AEBD_TABLES","APEX_1941389856444596","SYSAUX","SYSTEM","TEMP","USERS","USER_TABLE","WORK_TABLE","WORK_TEMP"],
      datasets: [
        {
          label: "free",
          backgroundColor: ["#00b33c","#00b33c","#00b33c","#00b33c","#00b33c","#00b33c","#00b33c","#00b33c","#00b33c"],
          data: myValue

        },
         {
          label: "used",
          backgroundColor: ["#990000","#990000","#990000","#990000","#990000","#990000","#990000","#990000","#990000"],
          data: myUsed
        }
      ]
    },
    options: {
      scales: {
        xAxes: [{
          barPercentage: 0.3
        }],
        yAxes: [{
          barPercentage: 0.3
        }]
      },
      legend: { display: false },
      title: {
        display: true,
        text: 'Informação de Espaço dos Tablespaces'
      }
    }
});


})


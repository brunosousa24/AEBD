const MEMCHART = document.getElementById("memoryChart");
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




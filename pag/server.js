/*
Iniciar servidor que trata de pedidos
*/
var express = require('express');
var app = express();
var db = require('oracledb');

app.set('view engine', 'pug');

app.get('/', (req,res) => {
	res.render('index');
})

app.get('/app/cpu/:metricas',(req,res) => {
	if(req.params.metricas == null){
		res.render('cpu')
	}else{


	db.getConnection(	{
    user          : "Work",
    password      : "work1",
    connectString : "localhost/1521"
  	},
  function(err, connection)
  {
    if (err) {
      console.error(err.message);
      return;
    }
    connection.execute(
      "SELECT "+req.params.metricas+"FROM  CPU",
      function(err, result)
      {
        if (err) {
          console.error(err.message);
          doRelease(connection);
          return;
        }
        //console.log(result.rows);

        var obj = {};
		obj.array=[];
		var array = result.rows;
		var arrayLength = array.length();
		for(var i =  0 ; i < arrayLength ;  i++){
			var aux = {}
			aux.exemplo = array[i][0]
			obj.array.push(aux)
		}

		res.render('cpu', obj)
        doRelease(connection);
      });
});
}
	/*
		Fazer ligação a BD
	*/
	// Query
	/*
		Obtens um array de rows do select
	*/
	//Conversão
	


	
})


app.listen(5555 , () => {
	console.log("Servidor iniciado!");
})


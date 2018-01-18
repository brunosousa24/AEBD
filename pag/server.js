/*
Iniciar servidor que trata de pedidos
*/
var express = require('express');
var app = express();
var db = require('oracledb');

app.set('view engine', 'pug');

app.use(express.static(__dirname+'/javascripts'))

app.get('/', (req,res) => {
	res.render('index');
})


app.get('/app/cpu/:metricas',(req,res) => {
	db.getConnection(	{
    user          : "Work",
    password      : "work1",
    connectString: "localhost/orcl"
  	},
  function(err, connection)
  {
    if (err) {
      console.error(err.message);
      return;
    }
    connection.execute(
      "SELECT DBID FROM  CPU",
      function(err, result)
      {
        if (err) {
          console.error(err.message);
          app.doRelease(connection);
          return;
        }
        //console.log(result.rows);

        var obj = {};
		obj.array=[];
		var array = result.rows;
		var arrayLength = array.length;
		for(var i =  0 ; i < arrayLength ;  i++){
			var aux = {}
			aux.exemplo = array[i][0]
			obj.array.push(aux)
		}

		res.render('cpu', obj)
        app.doRelease(connection);
      });
	});
});

	/*
		Fazer ligação a BD
	*/
	// Query
	/*
		Obtens um array de rows do select
	*/
	//Conversão
	
app.doRelease = function(connection) {
    connection.release(function(err) {
        if (err) {
            console.log("ERROR: Unable to RELEASE the connection: ", err);
        }
        return;
    });
};


app.listen(5555 , () => {
	console.log("Servidor iniciado!");
})


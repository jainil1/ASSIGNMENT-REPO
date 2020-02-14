var express = require('express');
var app = express();
var bodyParser  = require('body-parser');
var mysql = require('mysql');
var http = require('http');

app.use(bodyParser.json());


app.use(bodyParser.urlencoded({
    extended:true
}));


app.get('/',function(req, res){
    return res.send({ error : true,
        message :'NODE IS HEREEEE!!!!' })

});

app.listen(3000, function(){
    console.log('NODE ALL RUNNING !!!!!!!');
});
//for connecting to DB
var dbConn = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    password: 'admin',
    database:'user' 
});
    dbConn.connect();

//lets retrieve users !!

app.get('/users', function(req,res){
    dbConn.query('SELECT * FROM users',function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false , data: results , message : 'here is users list'});        
    });
});

//single user lets go!!

app.get('/user/:id', function(req,res){
    let user_id = req.params.id;
    dbConn.query('SELECT * FROM users where id =?',user_id,function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false , data: results , message : 'here is your USER!!!'});        
    });

});

//lets ADD USER 
app.post('/user',function(req,res){
    var user = req.body;
    dbConn.query("INSERT INTO users SET ?", user,function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false , data: results , message : 'NEW USER is added !!!'});        
    });
});


app.put('/update', function (req, res) {
    let user_id = req.body.id;
    let user = req.body;
     dbConn.query("UPDATE users SET name = ? , email = ? , created_at = ? WHERE id = ?", [user.name, user.email , user.created_at , user_id], function (error, results, fields) {
      if (error) throw error;
      return res.send({ error: false, data: results, message: 'user has been updated successfully.' });
     });
    });

// //updating 
//  app.post('/update',function(req,res){
//      console.log(req.body)
//      dbConn.query('UPDATE users SET  name =?, email =?, created_at =? where id =?', [name, email , created_at , id] , function(error,results,fields){
//          if(error) throw error;
//          return res.send({ error: false , data: results , message : 'USER is updateded !!!'});        
//      });
//  });


app.delete('/user',function(req,res){
    dbConn.query('DELETE from users  where id =?', [id] , function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false , data: results , message : 'OOPSSSS !!USER is DELETEd !!!'});        
    });

});


module.exports=app;
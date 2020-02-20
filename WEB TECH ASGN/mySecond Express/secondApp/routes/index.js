var express = require('express');
var router = express.Router();
var  mysql = require('mysql');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

//for connecting to DB
var dbConn = mysql.createConnection({
  host : 'localhost',
  user : 'root',
  password: 'admin',
  database:'user' 
});
  dbConn.connect();

router.get('/users',function(req,res){
  dbConn.query('SELECT * from users', function(error, results){
    if (error) throw error;
    return res.send({ data : results

    });
  });
});

router.post('/user',function(req,res){
  let user = req.body;
  dbConn.query("INSERT into users SET ?",user,function(error, results){
    if (error) throw error;
    
    return res.send({error:false,data:results});
  });
});

router.get('/user/:id',function(req,res){
  var id = req.params.id;
  dbConn.query('SELECT * FROM users where id =?',id,function(error,results){
    if(error) throw error;
    return res.send({ error: false , data: results , message : 'here is your USER!!!'});        
});

});

router.put('/update', function (req, res) {
  let user_id = req.body.id;
  let user = req.body;
   dbConn.query("UPDATE users SET name = ? , email = ? , created_at = ? WHERE id = ?", [user.name, user.email , user.created_at , user_id], function (error, results, fields) {
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'user has been updated successfully.' });
   });
  });

router.delete('/delete',function(req,res){
  let user_id = req.body.id;
  dbConn.query('DELETE FROM users WHERE id = ?', [user_id], function(error, results){
    if (error) throw error;
    return res.send({ error: false, data: results, message: 'user has been delted successfully.' });
  });
});


module.exports = router;

const JokeController = require('../controllers/jokes.controller')


module.exports = (app)=>{
    app.get('/api/jokes',JokeController.getAll)

    app.post('/api/jokes',JokeController.create)
    
    app.get('/api/jokes/:id',JokeController.getOne)
    
    app.put('/api/jokes/:id',JokeController.update)
    
    app.delete('/api/jokes/:id',JokeController.delete)
    
}
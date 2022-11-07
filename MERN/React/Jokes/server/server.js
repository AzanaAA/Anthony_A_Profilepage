const express = require('express')
const app= express()
const port = 8000
app.use(express.json())
app.use(express.urlencoded({extended:true}))

require ('./server/config/mongoose.config')
const routes =require('./server/routes/jokes.routes')
routes(app)

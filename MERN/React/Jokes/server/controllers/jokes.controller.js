const Joke = require('../models/jokes.model')

module.exports ={
    getAll:(req,res)=>{
        Joke.find({})
        .then((jokes)=>{
            res.json(jokes)
        })
        .catch((err)=>{
            res.status(400).json({msg:"Something went wrong", err})
        })
    },
    create: (req,res)=>{
        Joke.create(req.body)
        .then((joke)=>{
            res.json(joke)
        })
        .catch((err)=>{
            res.status(400).json({msg:"Something went wrong", err})
        })
    },
    getOne:(req,res)=>{
        Joke.findOnes({_id:req.params.id})
        .then((joke)=>{
            res.json({joke})
        })
        .catch((err)=>{
            res.json({msg:"Something went wrong",err})
        })
    },
    update:(req,res)=>{
        Joke.findOneAndUpdate({_id:req.params.id},req.body,{new:true})
        .then((joke)=>{
            res.json({joke})
        })
        .catch((err)=>{
            res.json({msg:"Something went wrong", err})
        })
    },
    delete:(req,res)=>{
        Joke.findOneAndDelete({_id:req.params.id})
        .then((joke)=>{
            res.json({joke})
        })
        .catch((err)=>{
            res.json({msg:"Something went wrong", err})
        })
    }

}

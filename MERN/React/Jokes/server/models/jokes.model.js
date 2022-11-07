const Mongoose = require('mongoose')

const JokeSchema = new Mongoose.Schema(
{
    setup: {
    type: String,
    minLength: [10, 'Setup must have at least 10 characters']
    },
    punchline: {
    type: String,
    minLength: [3, 'Punchline must have at least 3 characters']
    }
},
{ timestamps: true }
)

const Joke = mongoose.model('Joke', JokeSchema)

module.exports = Joke
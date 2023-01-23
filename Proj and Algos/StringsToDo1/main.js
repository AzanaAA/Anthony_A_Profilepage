//Question 1
function removeBlanks(str){
    let newString=''
    
    for(let char in str){
        if(str[char]!=''){
            newString +=str[char]
        }
    }
    return newString
}
console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "))


//Question 2
function getDigits(str){
    let newNumber=''

    for(let char in str){
        if(!isNaN(str[char])){
            newNumber += str[char]
        }
    }
    return Number(newNumber)
}
console.log(getDigits("abc8c0d1ngd0j0!8"))




//Question 3


function acronym(str){
    let wordsArray= str.split('')
    let acronymString=''

    for(let word in wordsArray){
        if(wordsArray[word].length>0){
            acronymString += wordsArray[word][0].toUpperCase()
        }
    }
    return acronymString
}
console.log (acronym(" there's no free lunch - gotta pay yer way. "))


//Question 4

function countNonSpaces(str){
    let counter=0
    for(let char in str){
        if(str[char]!=''){
            counter++
        }
    }
    return counter
}

console.log (countNonSpaces("Honey pie, you are driving me crazy"))



//Question 5

function removeShorterStrings(arr,len){
    let newStrings = []
    let nextIndex = 0

    for(let value in arr){
        if(arr[value].length >= len){
            newStrings[nextIndex++]= arr[value]
        }
    }
    return newStrings
}


console.log (removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4))
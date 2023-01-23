// Question 1

function pushFront(arr , val){
    for(let i = arr.length; i >= 0; i--){
        arr[i] = arr[i - 1]
    }
    arr [0] = val
    return arr
}
console.log(pushFront([5,7,2,3],8))


//Question 2

function popFront(arr) {
    let firstValue = arr[0]
    for(let i = 0; i < arr.length; i ++){
        arr [i] = arr[i + 1]
    }
    arr.length = arr.length - 1

    console.log(arr)

    return firstValue
}

console.log(popFront([4,5,7,9]))


//Question 3

function insertAt(arr, index, value){
    for(let i = arr.length; i >= index; i--){
        arr[i] = arr[i - 1]
    }
    arr[index] = value
    return arr
}

console.log(insertAt([100,200,5],2,211))
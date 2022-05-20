var count=1;
var counttwo=1;
var countthree=1;

var countElement=document.querySelector("#count");
var countTwo=document.querySelector("#counttwo");
var countThree=document.querySelector("#countthree");

function add(){
    count++;
    countElement.innerText=count+"like(s)"
    console.log (count);
}

function addtwo(){
    counttwo++;
    countTwo.innerText=counttwo+"like(s)"
    console.log (counttwo);
}

function addthree(){
    countthree++;
    countThree.innerText=countthree+"like(s)"
    console.log (countthree);
}
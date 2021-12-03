document.getElementById("btn1").addEventListener('click', participate);
let idx = 0;
function participate(){
    const pName = prompt('insert yout player name','player name');    
    document.getElementById("btn1").innerHTML = `PLAYER ${++idx} : ${pName}`;
}
const array = [273, 'String', true, function() {}, [], [273, 103]];
console.log(array);
console.log(array[1]);
console.log(array.length);
array.push('추가된 자료');
array.push(false);
array.push(5.23)
console.log(array);
array.pop();
console.log(array);
array.splice(2,3); // 2번부터 3개 삭제
console.log(array);

let sIndex = array.indexOf(273);
console.log(array);
array.splice(sIndex, 1);
console.log(array);
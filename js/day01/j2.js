// const pi = 3.14;
// pi = 4.5;
// console.log(pi);
// console.log(name);


// let pAge = 10;
// pAge -= 5;
// console.log(pAge);

// pAge = 30;
// pAge *= 10;
// console.log(++pAge);


// let list='';

// list += '<ul>';
// list += '   <li>사과</li>';
// list += '   <li>딸기</li>';
// list += '   <li>바나나</li>';
// list += '   <li>포도</li>';
// list += '</ul>';
// document.write(list);


// let number = 10;
// document.write(number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");
// document.write(++number + "&nbsp;");


// let sNum = "123";
// console.log(sNum);

// intNum = Number(sNum);
// console.log(intNum);


// const input = prompt('숫자입력','기본값');
// let sNu = input;
// let iNu = Number(sNu)
// alert(iNu + 500);
// let sSen = String(iNu) + "점입니다";
// alert(sSen);


// const input1 = prompt('숫자입력','단위 : cm');
// alert(Number(input1)*0.393701 + "인치");

// const input2 = prompt('숫자입력','달러 단위의 금액을 입력해 주세요');
// alert("원화 : " + 1178.90*Number(input2) + "원 입니다");

// console.log(Boolean(0));
// console.log(Boolean(!10));
// console.log(Boolean(!true));
// console.log(Boolean(!'Hello'));
// console.log(Boolean(!!false));


// const date = new Date();
// console.log(date.getFullYear() + "년 " + (date.getMonth()+1) + "월 " +
// date.getDate() + "일 지금 시간은 " + date.getHours() + "시 " +
// date.getMinutes() + "분 " + date.getSeconds() + "초입니다.");
// if(date.getHours() >= 12)
//     console.log('오후입니다.');
// else
//     console.log('오전입니다.');

// const date = new Date();
// let hour = date.getHours();
// if (8 <= hour && hour < 9) 
//     alert("아침 먹을 시간입니다.");
// else if (12 <= hour && hour < 13) 
//     alert("점심 먹을 시간입니다.");
// else if (18 <= hour && hour < 20) 
//     alert("저녁 먹을 시간입니다.");
// else 
//     alert("때를 놓쳤군요");


// const input = Number(prompt('숫자를 입력하세요', '숫자'));
// switch(input % 2){
//     case 0:
//         alert(` ${input}은 짝수입니다`);
//         break;
//     case 1:
//         alert(` ${input}은 홀수입니다`);
//         break;
// }


// const input = prompt('문자를 입력하세요', '문자');
// switch(input){
//     case 'a': case 'A':
//         alert('Ant - 개미, Animal - 동물');
//         break;
//     case 'b': case 'B':
//         alert('ball - 공, bear - 곰');
//         break;
//     case 'c': case 'C':
//         alert('cat - 고양이, car - 자동차');
//         break;
//     default:
//         alert('오늘은 ABC까지만 공부합니다');
// }


// const year = Number(prompt('태어난 연도', '1900'));
// const ttiArr = ['원숭이', '닭', '개', '돼지', '쥐', '소', '호랑이', '토끼', '용', '뱀', '말', '양'];
// const tti = '원숭이,닭,개,돼지,쥐,소,호랑이,토끼,용,뱀,말,양'.split(',');
// alert(`${year}년에 태어났다면 ${tti[year%12]} 띠입니다`);


let st = prompt("입학년도;학원명;반명;구분;이름 순으로 입력해주세요", "문자열입력");
st = st.split(";");
let year = st[0];
let company = st[1];
let class_1 = st[2];
let sep = st[3];
let name = st[4];
let st_1 = `입학년도 : ${year}, 학원명 : ${company}, 반명 : ${class_1}, 구분 : ${sep}, 이름 : ${name}`;
st_1 += sep == "학생"? "\n화이팅!" : "\n감사합니다.";
alert(st_1);
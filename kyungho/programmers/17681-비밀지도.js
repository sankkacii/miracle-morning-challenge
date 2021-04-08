"use strict";

function toBinary(n, num) {
  let binary = [];
  for (const _ of [...Array(n)]) {
    binary.push(num % 2);
    num = Math.floor(num / 2);
  }
  return binary.reverse();
}

function solution(n, arr1, arr2) {
  const answer = arr1.map((a, i) => {
    let a2 = toBinary(n, a);
    let b2 = toBinary(n, arr2[i]);
    [a2, b2] = a2.length < b2.length ? [b2, a2] : [a2, b2];
    const union = a2
      .map((x, i) => {
        const y = b2[i] ? b2[i] : 0;
        const sum = x + y > 1 ? 1 : x + y;
        return sum;
      })
      .map((x) => x.toString(10))
      .map((x) => (x === "1" ? "#" : " "))
      .join("");
    return union;
  });
  return answer;
}

console.log(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]));

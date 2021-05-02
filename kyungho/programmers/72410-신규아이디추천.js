function solution(new_id) {
  new_id = new_id.toLowerCase();
  new_id = new_id
    .split("")
    .filter((x) => /[\w\d.\-_]/.test(x))
    .join("");
  new_id = new_id.replace(/[.]{2,}/g, ".");
  new_id = new_id
    .split("")
    .filter((x, i) =>
      (i === 0 && x === ".") || (i === new_id.length - 1 && x === ".")
        ? false
        : true
    )
    .join("");
  new_id = new_id.length === 0 ? "a" : new_id;
  new_id = new_id.length >= 16 ? new_id.slice(0, 15) : new_id;
  new_id = new_id.slice(-1)[0] === "." ? new_id.slice(0, -1) : new_id;
  while (new_id.length < 3) {
    new_id += new_id.slice(-1)[0];
  }
  return new_id;
}

console.log(solution("...!@BaT#*..y.abcdefghijklm"));
console.log(solution("abcdefghijklmn.p"));

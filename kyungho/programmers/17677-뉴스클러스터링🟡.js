function makeMultiset(str) {
  const multiset = Array.from(str).reduce((obj, _, index) => {
    if (index === str.length - 1) {
      return obj;
    }
    const slice = str.slice(index, index + 2);
    if (slice.match(/[^a-z]/)) {
      return obj;
    }
    slice in obj ? (obj[slice] += 1) : (obj[slice] = 1);
    return obj;
  }, {});
  return multiset;
}

function getJaccard(set1, set2) {
  console.log("set1, set2", set1, set2);
  const intersection = Object.keys(set1).reduce(
    (acc, cur) =>
      cur in set2
        ? Object.assign(acc, { [cur]: Math.min(set1[cur], set2[cur]) })
        : acc,
    {}
  );
  const union = Object.assign({}, set1);
  Object.keys(set2).forEach((key) =>
    key in union
      ? (union[key] = Math.max(union[key], set2[key]))
      : (union[key] = 1)
  );
  console.log(intersection, union);
  const size1 = Object.values(intersection).reduce((acc, cur) => acc + cur, 0);
  const size2 = Object.values(union).reduce((acc, cur) => acc + cur, 0);
  return size2 === 0 ? 1 : size1 / size2;
}

function solution(str1, str2) {
  str1 = str1.toLowerCase();
  str2 = str2.toLowerCase();
  console.log(str1, str2);
  const multiset1 = makeMultiset(str1);
  const multiset2 = makeMultiset(str2);
  // console.log(multiset1, multiset2);
  return Math.floor(getJaccard(multiset1, multiset2) * 65536);
}

console.log(solution("FRANCE", "french"));
console.log(solution("handshake", "shake hands"));
console.log(solution("aa1+aa2", "AAAA12"));
console.log(solution("E=M*C^2", "e=m*c^2"));

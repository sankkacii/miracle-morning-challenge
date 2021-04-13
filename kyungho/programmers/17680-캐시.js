function solution(cacheSize, cities) {
  let cache = [];
  let time = 0;
  cities.forEach((city) => {
    console.log(cache);
    if (
      cache.find(
        ([cityInCahce, _]) => cityInCahce.toLowerCase() === city.toLowerCase()
      )
    ) {
      cache = cache.map(([cityInCache, time]) => {
        if (cityInCache.toLowerCase() === city.toLowerCase()) {
          return [city, 0];
        }
        return [cityInCache, time];
      });

      cache = cache.map(([city, time]) => [city, time + 1]);
      time += 1;
      console.log("+1", time);
      return;
    }

    cache.push([city, 0]);
    if (cache.length > cacheSize) {
      const maxTime = Math.max(...cache.map(([_, time]) => time));
      const index = cache.findIndex(([_, time]) => time === maxTime);
      cache.splice(index, 1);
    }
    cache = cache.map(([city, time]) => [city, time + 1]);
    time += 5;
    console.log("+5", time);
  });
  return time;
}

// console.log(
//   solution(
//     3,
//     [
//       "Jeju",
//       "Pangyo",
//       "Seoul",
//       "NewYork",
//       "LA",
//       "Jeju",
//       "Pangyo",
//       "Seoul",
//       "NewYork",
//       "LA",
//     ],
//     ["fr*d*", "abc1**"]
//   )
// );

// console.log(
//   solution(3, [
//     "Jeju",
//     "Pangyo",
//     "Seoul",
//     "Jeju",
//     "Pangyo",
//     "Seoul",
//     "Jeju",
//     "Pangyo",
//     "Seoul",
//   ])
// );

console.log(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]));

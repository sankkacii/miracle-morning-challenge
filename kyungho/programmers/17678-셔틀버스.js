function convertToSeconds(timeString) {
  const [minutes, seconds] = timeString.split(":");
  return +minutes * 60 + +seconds;
}

function convertToString(seconds) {
  let minutes = Math.floor(seconds / 60);
  minutes = minutes < 10 ? `0${minutes}` : minutes;
  let newSeconds = seconds - minutes * 60;
  newSeconds = newSeconds < 10 ? `0${newSeconds}` : newSeconds;
  return `${minutes}:${newSeconds}`;
}

function solution(n, t, m, timetable) {
  const timesInSeconds = timetable.map((time) => [
    convertToSeconds(time),
    false,
  ]);
  let latestTime = 0;
  for (let i = 0; i < convertToSeconds("24:00"); i++) {
    let newTimeTable = [...timesInSeconds, [i, true]].sort(
      (a, b) => a[0] - b[0]
    );
    let bus = convertToSeconds("09:00");
    for (let j = 0; j < n; j++) {
      newTimeTable = newTimeTable
        .slice(0, m)
        .filter(([time, _]) => time > bus)
        .concat(newTimeTable.slice(m));
      bus += t;
    }

    newTimeTable = newTimeTable.map(([_, isCon]) => isCon);
    if (newTimeTable.includes(true)) {
      break;
    } else {
      latestTime = i;
    }
  }
  return convertToString(latestTime);
}

console.log(solution(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]));

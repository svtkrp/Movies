// yyyy-MM-dd'T'HH:mm:ss, zone - GMT
export default function getDateStr(date) {
    return "" + date.getUTCFullYear() + "-" + get2NumbersStr(date.getUTCMonth() + 1) + "-" + get2NumbersStr(date.getUTCDate())
      + "T" + get2NumbersStr(date.getUTCHours()) + ":" + get2NumbersStr(date.getUTCMinutes()) + ":" + get2NumbersStr(date.getUTCSeconds());
}
  
function get2NumbersStr(num) {
    return ((num < 10) ? "0" : "") + num;
}

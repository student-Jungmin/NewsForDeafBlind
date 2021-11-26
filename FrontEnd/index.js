import player from "./player.js";

window.addEventListener("load", player.start());


let btn_economy = document.querySelector('#economy');
btn_economy.onclick = () => {
    window.alert("click");  
    previousLimit = 0;
    nextLimit = 4;
    currentPlaying = previousLimit;
    document.querySelector('#specific-article-name').remove();
    const parent = document.querySelector('#article-name').createElement('p')
    parent.id = 'article-name';
    parent.innerHTML = "dasda";
}
// $(document).ready(function() {
//     //첫 번째 버튼 이벤트
//     $("#economy").on("click", function() {
//         previousLimit = 0;
//         nextLimit = 4;
//         currentPlaying = previousLimit;
//         $("p").remove("#specific-article-name");
//         let bodyHtml = ;
//         $("#article-name").append(bodyHtml);
//     });
//     $("#politic").on("click", function() {
//         previousLimit = 5;
//         nextLimit = 9;
//         currentPlaying = previousLimit;
//         $("p").remove("#specific-article-name");
//         let bodyHtml = "<p id=\"specific-article-name\">정치"+ (currentPlaying % 5 + 1) + "</p>";
//         $("#article-name").append(bodyHtml);
//     });
//     $("#social").on("click", function() {
//         previousLimit = 10;
//         nextLimit = 14;
//         currentPlaying = previousLimit;
//         $("p").remove("#specific-article-name");
//         let bodyHtml = "<p id=\"specific-article-name\">사회"+ (currentPlaying % 5 + 1) + "</p>";
//         $("#article-name").append(bodyHtml);
//     });
//     $("#international").on("click", function() {
//         previousLimit = 15;
//         nextLimit = 19;
//         currentPlaying = previousLimit;
//         $("p").remove("#specific-article-name");
//         let bodyHtml = "<p id=\"specific-article-name\">세계"+ (currentPlaying % 5 + 1) + "</p>";
//         $("#article-name").append(bodyHtml);
//     });
// });
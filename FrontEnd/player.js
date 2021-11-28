import audios from "./data.js";
import { path, secondsToMinutes } from "./utils.js";
import elements from "./playerElements.js";

export default {
  audioData: audios,
  currentAudio: {},
  currentPlaying: 0,
  previousLimit: 0,
  nextLimit: 4,
  isPlaying: false,
  start() {
    elements.get.call(this);
    this.update();
  },

  play() {
    window.alert(this.currentPlaying);
    this.isPlaying = true;
    this.audio.play();
    this.playPause.innerText = "pause";
  },

  pause() {
    this.isPlaying = false;
    this.audio.pause();
    this.playPause.innerText = "play_arrow";
  },

  togglePlayPause() {
    if (this.isPlaying) {
      this.pause();
    } else {
      this.play();
    }
  },

  toggleMute() {
    this.audio.muted = !this.audio.muted;
    this.mute.innerText = this.audio.muted ? "volume_down" : "volume_up";
  },

  next() {
    this.pause();
    this.currentPlaying++;
    if(this.currentPlaying > this.nextLimit) this.currentPlaying = this.nextLimit; 
    this.update();
    this.play();
  },

  previous() {
    this.pause();
    this.currentPlaying--;
    if(this.currentPlaying < this.previousLimit) this.currentPlaying = this.previousLimit; 
    this.update();
    this.play();
  },


  setVolume(value) {
    this.audio.volume = value / 100;
  },

  setSeek(value) {
    this.audio.currentTime = value;
  },

  timeUpdate() {
    this.currentDuration.innerText = secondsToMinutes(this.audio.currentTime);
    this.seekbar.value = this.audio.currentTime;
  },

  update() {
    this.currentAudio = this.audioData[this.currentPlaying];
    //this.title.innerText = this.currentAudio.title;
    //this.artist.innerText = this.currentAudio.artist;
    
    if(this.previousLimit == 0) document.querySelector("#specific-article-name").innerText = "경제 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
    else if(this.previousLimit == 5) document.querySelector("#specific-article-name").innerText = "정치 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
    else if(this.previousLimit == 10) document.querySelector("#specific-article-name").innerText = "사회 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
    else if(this.previousLimit == 15) document.querySelector("#specific-article-name").innerText = "세계 "+ (this.currentPlaying % 5 + 1) + "번째 기사";

    elements.createAudioElement.call(this, path(this.currentAudio.file));

    this.audio.onloadeddata = () => {
      elements.actions.call(this);
    };
  },

  restart() {
    this.currentPlaying = 0;
    this.update();
  },

  setSubjectToEconomy() {
    this.previousLimit = 0;
    this.nextLimit = 4;
    this.currentPlaying = this.previousLimit;

    document.querySelector("#specific-article-name").innerText = "경제 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
  },

  setSubjectToPolicy() {
    this.previousLimit = 5;
    this.nextLimit = 9;
    this.currentPlaying = this.previousLimit;

    document.querySelector("#specific-article-name").innerText = "정치 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
  },

  setSubjectToSocial() {
    this.previousLimit = 10;
    this.nextLimit = 14;
    this.currentPlaying = this.previousLimit;

    document.querySelector("#specific-article-name").innerText = "사회 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
  },

  setSubjectToInternational() {
    this.previousLimit = 15;
    this.nextLimit = 19;
    this.currentPlaying = this.previousLimit;

    document.querySelector("#specific-article-name").innerText = "세계 "+ (this.currentPlaying % 5 + 1) + "번째 기사";
  }
};


/* <script>
    $("#social").on("click", function() {
        previousLimit = 10;
        nextLimit = 14;
        currentPlaying = previousLimit;
        $("p").remove("#specific-article-name");
        let bodyHtml = "<p id=\"specific-article-name\">사회 "+ (currentPlaying % 5 + 1) + "번째 기사" + "</p>";
        $("#article-name").append(bodyHtml);
    });
    $("#international").on("click", function() {
        previousLimit = 15;
        nextLimit = 19;
        currentPlaying = previousLimit;
        $("p").remove("#specific-article-name");
        let bodyHtml = "<p id=\"specific-article-name\">세계 "+ (currentPlaying % 5 + 1) + "번째 기사" + "</p>";
        $("#article-name").append(bodyHtml);
    });
});
</script> */
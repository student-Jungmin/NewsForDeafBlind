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
    elements.createAudioElement.call(this, path(this.currentAudio.file));

    this.audio.onloadeddata = () => {
      elements.actions.call(this);
    };
  },

  restart() {
    this.currentPlaying = 0;
    this.update();
  }
};

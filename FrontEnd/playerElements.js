import { secondsToMinutes } from "./utils.js";

export default {
  get() {
    this.title = document.querySelector(".card-content h5");
    this.btn_previous = document.querySelector("#btn_previous");
    this.playPause = document.querySelector("#play-pause");
    this.btn_next = document.querySelector("#btn_next");
    this.mute = document.querySelector("#mute");
    this.volume = document.querySelector("#vol-control");
    this.seekbar = document.querySelector("#seekbar");
    this.currentDuration = document.querySelector("#current-duration");
    this.totalDuration = document.querySelector("#total-duration");
  },
  createAudioElement(audio) {
    this.audio = new Audio(audio);
  },
  actions() {
    this.btn_next.onClick = () => this.next();
    this.btn_previous.onClick = () => this.previous();
    this.audio.ontimeupdate = () => this.timeUpdate();
    this.playPause.onclick = () => this.togglePlayPause();
    this.mute.onclick = () => this.toggleMute();
    this.volume.oninput = () => this.setVolume(this.volume.value);
    this.volume.onchange = () => this.setVolume(this.volume.value);
    this.seekbar.oninput = () => this.setSeek(this.seekbar.value);
    this.seekbar.onchange = () => this.setSeek(this.seekbar.value);
    this.seekbar.max = this.audio.duration;
    this.totalDuration.innerText = secondsToMinutes(this.audio.duration);
  }
};

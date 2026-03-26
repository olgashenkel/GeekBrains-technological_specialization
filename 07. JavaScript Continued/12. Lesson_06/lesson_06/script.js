"use strict";

const audioEL = document.querySelector(".audio");

audioEL.addEventListener("play", () => {
  console.log("Playing");
});

audioEL.addEventListener("pause", () => {
  console.log("Paused");
});
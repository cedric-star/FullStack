vue
<script>
export default {
  name: "GameMain",
  data() {
    return {
      context: null,
      isDrawing: false,
      lastX: 0,
      laseY: 0
    };
  },
  methods: {
    setupCanvas() {
      const canvas = this.$refs.myCanvas;
      canvas.width = window.innerWidth;
      canvas.height = window.innerHeight;

      this.context = canvas.getContext('2d');
      this.context.strokeStyle = '#BADA55'; // Stiftfarbe festlegen
      this.context.lineJoin = 'round';
      this.context.lineCap = 'round';
      this.context.lineWidth = 5; // Stiftbreite festlegen
// Event-Listener für Maus
      canvas.addEventListener('mousedown', this.startDrawing);
      canvas.addEventListener('mousemove', this.draw);
      canvas.addEventListener('mouseup', this.stopDrawing);
      canvas.addEventListener('mouseout', this.stopDrawing); // Beenden, falls Maus die Leinwand verlässt

      // Optional: Touch-Ereignisse für mobile Geräte
      canvas.addEventListener('touchstart', this.startDrawing);
      canvas.addEventListener('touchmove', this.draw);
      canvas.addEventListener('touchend', this.stopDrawing);
    },
  startDrawing(event) {
    this.drawing = true;
    const {x, y} = this.getMousePosition(event);
    this.lastX = x;
    this.lastY = y;
    this.context.beginPath();
    this.context.moveTo(this.lastX, this.lastY);
  },

  draw(event) {
    if (!this.drawing) return;

    event.preventDefault();
    const {x, y} = this.getMousePosition(event);

    this.context.lineTo(x, y);
    this.context.stroke();

    this.lastX = x;
    this.lastY = y;
  },

  stopDrawing() {
    this.drawing = false;
    this.context.closePath();
  },

  getMousePosition(event) {
    const canvas = this.$refs.myCanvas;
    const rect = canvas.getBoundingClientRect();

    let clientX = event.clientX;
    let clientY = event.clientY;

    if (event.touches) {
      clientX = event.touches[0].clientX;
      clientY = event.touches[0].clientY;
    }

    return {
      x: clientX - rect.left,
      y: clientY - rect.top
    };
  },
},
  mounted() {
    this.setupCanvas();
    window.addEventListener('resize', this.setupCanvas);
  },
  beforeUnmount() {
    window.removeEventListener('resize', this.setupCanvas);
  }
}

</script>

<template @keydown.w="keyPressed"
@keydown.space="keyPressed">
  <div id="all">
    <div style="position: relative;">
      <canvas
          ref="myCanvas"

      ></canvas>
    </div>
  </div>
</template>

<style scoped>
canvas {
  display: block; /* Entfernt unnötigen zusätzlichen Platz unter dem Canvas */
  width: 100vw;   /* 100% der Breite des Viewports */
  height: 100vh;  /* 100% der Höhe des Viewports */
  margin: 0;      /* Keine äußeren Abstände */
  padding: 0;     /* Keine inneren Abstände */
  box-sizing: border-box; /* Enthält Rand und Auffüllung in den Berechnungen der Breite/Höhe */

}
#all {
  margin: 0;
  padding: 0;
  overflow: hidden; /* Verhindert Scrollbalken auf der Seite */
  height: 100%;
  width: 100%;
}
</style>
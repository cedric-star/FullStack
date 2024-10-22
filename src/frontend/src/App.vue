<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>

  <header>

    <div class="wrapper">
      <nav>
        <RouterLink to="/"> HomePage </RouterLink>
        <RouterLink to="/game"> MyGame </RouterLink>
        <RouterLink to="/login"> Login </RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  font-size: large;
  position: fixed; /* Fixiert den Header */
  top: 0;         /* Positioniert den Header oben */
  left: 0;        /* Positioniert den Header links */
  width: 100%;    /* Breite auf 100% setzen */
  background: #589595;
  z-index: 1000;  /* Sicherstellen, dass der Header oben bleibt */
  padding: 10px;  /* Innenabstand */
  padding-bottom: 1.2%;
}

nav a.router-link-exact-active {
  color: rebeccapurple;
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}



</style>

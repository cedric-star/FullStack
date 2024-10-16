vue
<script>
  import Liste from './Liste.vue'
  export default {
    name: "LoginWindow",
    data() {
      return {
        name: '',
        email: '',
        pass: '',
        bday: '',
        pnum: '',
        inputs: [],
        messages: [],
        regexes: [],

        msgName: '',
        msgEmail: '',
        msgPassword: '',
        msgBday: '',
        msgNumber: ''
      };
    },
    methods: {
      updateMessages() {
        this.isInputValid();
        this.buildMessages();
      },

      send() {
        this.buildArrs();

        if (this.isInputValid()) {
          this.sendData();}

        this.buildMessages();
      },

      buildMessages() {
        this.msgName=this.messages[0];
        this.msgEmail=this.messages[1];
        this.msgPassword=this.messages[2];
        this.msgBday=this.messages[3];
        this.msgNumber=this.messages[4];
      },
      buildArrs() {
        this.inputs[0] =this.name;
        this.inputs[1] =this.email;
        this.inputs[2] =this.pass;
        this.inputs[3] =this.bday;
        this.inputs[4] =this.pnum;

        this.regexes[0]=/^[a-zA-Z]+$/;
        this.regexes[1]=/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z0-9.-]+$/;
        this.regexes[2]=/^[a-zA-Z0-9]+$/;
        this.regexes[3]= /^\d{4}-\d{2}-\d{2}$/;
        this.regexes[4]=/^[0-9]+$/;
      },
      isInputValid() {

        for (let i=0; i < this.inputs.length; i++) {
          if(this.regexes[i].test(this.inputs[i])) {
            this.messages[i]="correct";
          }
          else {
            this.messages[i]="wrong format";
            if (!this.inputs[i]===""){
              this.messages="";
            }
            return false;
          }
        }
        return true;
      },

      sendData: function () {
        console.log("sending data...");
        const dataJson = {
          name: this.name,
          email: this.email,
          pass: this.pass,
          bday: this.bday,
          pnum: this.pnum
        };
        fetch('/app/getuserdata', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(dataJson)
        })
            .then(response => response.text())
            .then(console.log("data was succesfully send!"))
            .then((data) => {
              console.log(data);
            })
            .then((data) => {
              if (data.success) {
                console.log('success... opening list for logged in user');
                this.
              }
            })
            .catch(error => {
            console.error("Es gab einen Fehler:", error);
            });

      }
    }

  }

</script>

<template>
<div id="all">
  <div id="content">
    <ol>
      <div id="inputdivtop">
        <p>Name: </p>
        <input id="inputfield" type="text" placeholder="name" v-model="name" @change="updateMessages()">
        <b><p id="message">{{ msgName }}</p></b>
      </div>

      <div id="inputdiv">
        <p>E-mail: </p>
        <input id="inputfield" type="email" placeholder="email" v-model="email" @change="updateMessages()">
        <b><p id="message">{{ msgEmail }}</p></b>
      </div>

      <div id="inputdiv">
        <p>Password: </p>
        <input id="inputfield" type="password" placeholder="pass" v-model="pass" @change="updateMessages()">
        <b><p id="message">{{ msgPassword }}</p></b>
      </div>

      <div id="inputdiv">
        <p>Birthday: </p>
        <input id="inputfield" type="date" placeholder="bday" v-model="bday" @change="updateMessages()">
        <b><p id="message">{{ msgBday }}</p></b>
      </div>

      <div id="inputdivbot">
        <p>Phone Number: </p>
        <input id="inputfield" type="number" placeholder="pnum" v-model="pnum" @change="updateMessages()">
        <b><p id="message">{{ msgNumber }}</p></b>
      </div>

    </ol>
    <ol id="senddiv">
      <button id="sendinput" type="submit" @click="send()">Send</button>
    </ol>
  </div>

</div>

</template>

<style scoped>
#all {
  border: 1px solid darkslategray;
  background-color: beige;
  display: flow-root;
}

#message {
  color: indianred;
  padding-top: 1px;
  margin: 0px;
  font-size: small;
}

#sendinput {
  border: 2px solid darkslategray; /* Rahmenbreite, -stil und -farbe */
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: burlywood;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  animation: alternate;
  transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
}
#sendinput:hover {
  border: 2px solid lightslategray; /* Rahmenbreite, -stil und -farbe */
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: #daaf78;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  animation: alternate;
  transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
}
#sendinput:active {
  border: 2px solid darkslategray; /* Rahmenbreite, -stil und -farbe */
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: #d5a86f;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}

#inputdivtop {
  border: 2px solid darkslategray; /* Rahmenbreite, -stil und -farbe */
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: burlywood;
}
#inputdiv {
  border: 2px solid darkslategray; /* Rahmenbreite, -stil und -farbe */
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: burlywood;
}
#inputdivbot {
  border: 2px solid darkslategray; /* Rahmenbreite, -stil und -farbe */
  border-bottom-right-radius: 20px;
  padding: 5px; /* Innenabstand */
  padding-top: 1px;
  margin: 8px; /* Außenabstand */
  display: compact;
  background-color: burlywood;
}

#inputfield {
  border: none;
  color: darkgray;
  background: beige;
  border-radius: 3px;
  margin: 1px;
}

#content {
  display: inline-block;
}
</style>
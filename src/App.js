import { useState } from "react";
import TextField from '@mui/material/TextField';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import axios from "./axios";

function App() {
  const [chains, setChains] = useState();
  const [columns, setColumns] = useState();
  const [rotations, setRotation] = useState();
  const [key, setKey] = useState();
  const [keywords, setKeywords] = useState();
  const [encoder, setEncoder] = useState();
  const [decoder, setDecoder] = useState();

  const generatedKeys = async() => {
    let reqOptions = {
      url: `/product/generate-key?chain=${chains}&keyword=${keywords}`,
      method: "POST"
    }
    
    axios.request(reqOptions).then(function (response) {
      setKey(response.data);
    })
  } 

  const generateEncoder = () => {
    let reqOptionsEncoder = {
      url: `/product/encrypt?chain=${chains}&columns=${columns}&key=${key}&rotations=${rotations}`,
      method: "POST"
    }
    
    axios.request(reqOptionsEncoder).then(function (response) {
      setEncoder(response.data);
    })
  }

  const generateDecoder = () => {
    let reqOptionsDecoder = {
      url: `/product/decipher?chain=${encoder}&columns=${columns}&key=${key}&rotations=${rotations}`,
      method: "POST"
    }
    
    axios.request(reqOptionsDecoder).then(function (response) {
      setDecoder(response.data);
    })
  }
  const send = async () => {
    generateEncoder()
    generateDecoder()
  };

  return (
    <div style={{margin: 10}}>    
      <TextField label="Chain" variant="outlined" value={chains} onChange={e => setChains(e.target.value)}/>
      <TextField label="Keyword" variant="outlined" value={keywords} onChange={e => setKeywords(e.target.value)}/>
      <Button variant="contained" onClick={generatedKeys}>Generate Key</Button>
      {
        key ? <Alert severity="success">This is Key — {key}</Alert> : <div></div>
      }
      <br/>
      <TextField
          id="outlined-number"
          label="Columns"
          type="number"
          InputLabelProps={{
            shrink: true,
          }}
          value={columns} onChange={e => setColumns(e.target.value)}
        />
        <TextField
          id="outlined-number"
          label="Rotations"
          type="number"
          InputLabelProps={{
            shrink: true,
          }}
          value={rotations} onChange={e => setRotation(e.target.value)}
        />
        <TextField label="Key" variant="outlined" value={key} onChange={e => setKey(e.target.value)}/>
      <Button variant="outlined" onClick={send}>Send</Button>

      {
        encoder ? <Alert severity="success">This is Encoder — {encoder}</Alert> : <div></div>
      }
       {
        decoder ? <Alert severity="success">This is Decoder — {decoder}</Alert> : <div></div>
      }
    </div>
  )
}

export default App;

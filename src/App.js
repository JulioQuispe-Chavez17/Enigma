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

  const sendData = async () => {
    let reqOptionsEncoder = {
      url: `/product/encrypt?chain=${chains}&columns=${columns}&key=${key}&rotations=${rotations}`,
      method: "POST"
    }
    
    axios.request(reqOptionsEncoder).then(function (response) {
      setEncoder(response.data);
    })

    let reqOptionsDecoder = {
      url: `/product/decipher?chain=${encoder}&columns=${columns}&key=${key}&rotations=${rotations}`,
      method: "POST"
    }
    
    axios.request(reqOptionsDecoder).then(function (response) {
      setDecoder(response.data);
    })
  };

  return (
    <div style={{margin: 10}}>    
      <TextField label="Chain" variant="outlined" value={chains} onChange={e => setChains(e.target.value)}/>
      <TextField label="Keyword" variant="outlined" value={keywords} onChange={e => setKeywords(e.target.value)}/>
      <Button variant="contained" onClick={generatedKeys}>Generate Key</Button>
      {
        key ? <Alert severity="success">This is a success alert — {key}</Alert> : <div></div>
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
      <Button variant="outlined" onClick={sendData}>Send</Button>

      {
        encoder ? <Alert severity="success">This is a success alert — {encoder}</Alert> : <div></div>
      }
       {
        decoder ? <Alert severity="success">This is a success alert — {decoder}</Alert> : <div></div>
      }
    </div>
  )
}

export default App;

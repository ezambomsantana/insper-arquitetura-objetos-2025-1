import { useState } from "react"
import { InputText } from "./InputText"
import {  Button, Grid, TextField } from "@mui/material"



export function ClienteForm() {

  const [nome, setNome] = useState()
  const [cpf, setCpf] = useState()

  const cadastrar = () => {
    let cliente = {
      'nome': nome,
      'cpf': cpf
    }

    fetch('http://localhost:8080/cliente', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(cliente)
    }).then(response => {
      return response.text()
    }).then(data => {
      alert(data)
    }).catch(error =>
      alert(error)
    )

  }

  return <>

    <Grid container spacing={4}>
      <Grid size={6}>
        <TextField variant="outlined" label="Nome" value={nome} onChange={e => setNome(e.target.value)} />
      </Grid>
      <Grid size={6}>
        <TextField variant="filled" label="CPF" value={cpf} onChange={e => setCpf(e.target.value)} />
      </Grid>
      <Grid size={12}>
        <Button variant="outlined" onClick={cadastrar}>Cadastrar</Button>
      </Grid>
    </Grid>
  </>

}

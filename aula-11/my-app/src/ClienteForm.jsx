import { useState } from "react"
import { InputText } from "./InputText"
import {  Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Grid, Snackbar, TextField } from "@mui/material"
import { useNavigate } from "react-router-dom"



export function ClienteForm() {

  const [nome, setNome] = useState()
  const [cpf, setCpf] = useState()
  const [open, setOpen] = useState(false);
  const [message, setMessage] = useState(false);

  const [openDialog, setOpenDialog] = useState(false);

  const navigate = useNavigate()

  const handleClickOpen = () => {
    setOpenDialog(true);
  };

  const handleCloseDialog = () => {
    setOpenDialog(false);
  };

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
      navigate('/listarClientes')
    }).catch(error => {
      setMessage('Erro ao cadastrar cliente')
      setOpen(true)
    })

    handleCloseDialog()

  }

  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setOpen(false);
  };

  return <>

      <Dialog
        open={openDialog}
        onClose={handleCloseDialog  }
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">
          Cadastro de Cliente
        </DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            Confirma o cadastro de cliente?
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCloseDialog}>Cancelar</Button>
          <Button onClick={cadastrar} autoFocus>
            Confirmar
          </Button>
        </DialogActions>
      </Dialog>

    <Snackbar
      open={open}
      autoHideDuration={6000}
      onClose={handleClose}
      message={message}
    />

    <Grid container spacing={4}>
      <Grid size={6}>
        <TextField variant="outlined" label="Nome" value={nome} onChange={e => setNome(e.target.value)} />
      </Grid>
      <Grid size={6}>
        <TextField variant="filled" label="CPF" value={cpf} onChange={e => setCpf(e.target.value)} />
      </Grid>
      <Grid size={12}>
        <Button variant="outlined" onClick={handleClickOpen}>Cadastrar</Button>
      </Grid>
    </Grid>
  </>

}

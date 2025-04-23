import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'
import { ContaTable } from './ContaTable'
import { ContaForm } from './ContaForm'
import { AppBar, Button, Menu, MenuItem, Toolbar } from '@mui/material'

function App() {

  const [menu, setMenu] = useState(0)

  const [anchorElCliente, setAnchorElCliente] = useState(null);
  const [anchorElConta, setAnchorElConta] = useState(null);

  const handleOpenCliente = (event) => {
    setAnchorElCliente(event.currentTarget);
  };

  const handleCloseCliente = () => {
    setAnchorElCliente(null);
  };

  const handleOpenConta = (event) => {
    setAnchorElConta(event.currentTarget);
  };

  const handleCloseConta = () => {
    setAnchorElConta(null);
  };


  return (
    <>

    <AppBar position="static" className='full-width'>
      <Toolbar>
        <Button color="inherit" onClick={handleOpenCliente}>
          Cliente
        </Button>
        <Menu
          anchorEl={anchorElCliente}
          open={Boolean(anchorElCliente)}
          onClose={handleCloseCliente}
        >
          <MenuItem onClick={() => { setMenu(0); handleCloseCliente(); }}>
            Cadastrar Cliente
          </MenuItem>
          <MenuItem onClick={() => { setMenu(1); handleCloseCliente(); }}>
            Listar Cliente
          </MenuItem>
        </Menu>

        <Button color="inherit" onClick={handleOpenConta}>
          Conta
        </Button>
        <Menu
          anchorEl={anchorElConta}
          open={Boolean(anchorElConta)}
          onClose={handleCloseConta}
        >
          <MenuItem onClick={() => { setMenu(2); handleCloseConta(); }}>
            Cadastrar Conta
          </MenuItem>
          <MenuItem onClick={() => { setMenu(3); handleCloseConta(); }}>
            Listar Contas
          </MenuItem>
        </Menu>
      </Toolbar>
    </AppBar>


      { menu == 0 && <ClienteForm></ClienteForm>}
      { menu == 1 && <ClienteTable></ClienteTable>}
      { menu == 2 && <ContaForm></ContaForm>}
      { menu == 3 && <ContaTable></ContaTable>}
      
      
    </>
  )
}

export default App

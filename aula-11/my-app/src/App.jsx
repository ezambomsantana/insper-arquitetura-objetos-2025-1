import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'
import { ContaTable } from './ContaTable'
import { ContaForm } from './ContaForm'
import { AppBar, Button, Menu, MenuItem, Toolbar } from '@mui/material'
import { Link, Route, Routes, useNavigate } from 'react-router-dom'

function App() {

  const [menu, setMenu] = useState(0)

  const [anchorElCliente, setAnchorElCliente] = useState(null);
  const [anchorElConta, setAnchorElConta] = useState(null);

  const navigate = useNavigate()


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

    <Routes>

      <Route path='/cadastrarCliente' element={<ClienteForm></ClienteForm>} />
      <Route path='/listarClientes' element={<ClienteTable></ClienteTable>} />
      <Route path='/cadastrarConta' element={<ContaForm></ContaForm>} />
      <Route path='/listarContas' element={<ContaTable></ContaTable>} />

    </Routes>

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
          <MenuItem onClick={() => { navigate('/cadastrarCliente'); handleCloseCliente(); }}>
            Cadastrar Cliente
          </MenuItem>
          <MenuItem onClick={() => { navigate('/listarClientes'); handleCloseCliente(); }}>
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
          <MenuItem onClick={() => { navigate('/cadastrarConta'); handleCloseConta(); }}>
            Cadastrar Conta
          </MenuItem>
          <MenuItem onClick={() => { navigate('/listarContas'); handleCloseConta(); }}>
            Listar Contas
          </MenuItem>
        </Menu>
      </Toolbar>
    </AppBar>
      
      
    </>
  )
}

export default App

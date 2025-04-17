import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'

function App() {

  const [clientes, setClientes] = useState([])
  const [menu, setMenu] = useState(0)



  return (
    <>

      <button onClick={() => setMenu(0)}>Cadastrar Cliente</button>
      <button onClick={() => setMenu(1)}>Listar Cliente</button>


      { menu == 0 && <ClienteForm clientes={clientes} setClientes={setClientes}></ClienteForm>}
      { menu == 1 && <ClienteTable clientes={clientes}></ClienteTable>}
      
      
    </>
  )
}

export default App

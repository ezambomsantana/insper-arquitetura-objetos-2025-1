import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'

function App() {

  const [menu, setMenu] = useState(0)




  return (
    <>

      <button onClick={() => setMenu(0)}>Cadastrar Cliente</button>
      <button onClick={() => setMenu(1)}>Listar Cliente</button>


      { menu == 0 && <ClienteForm></ClienteForm>}
      { menu == 1 && <ClienteTable></ClienteTable>}
      
      
    </>
  )
}

export default App

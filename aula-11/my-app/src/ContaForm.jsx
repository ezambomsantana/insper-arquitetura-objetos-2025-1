import { useEffect, useState } from "react"
import { InputText } from "./InputText"

export function ContaForm() {

  const [numeroConta, setNumeroConta] = useState()
  const [agencia, setAgencia] = useState()
  const [cpf, setCpf] = useState()
  const [clientes, setClientes] = useState([])

  const cadastrar = () => {
    let conta = {
      'numeroConta': numeroConta,
      'agencia': agencia,
      'principal': {
        'cpf': cpf
      }
    }

    fetch('http://localhost:8080/conta', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(conta)
    }).then(response => {
      return response.text()
    }).then(data => {
      alert(data)
    }).catch(error =>
      alert(error)
    )

  }

  useEffect(() => {

      fetch('http://localhost:8080/cliente', {
          method: 'GET'
      }).then(response => {
          return response.json()
      }).then(data => {
          setClientes(data.content)
      })

  }, [])

  return <>

    <InputText label={'Número Conta'} setValue={setNumeroConta} />
    <InputText label={'Agência'} setValue={setAgencia} ></InputText>
    <p>
      <select value={cpf} onChange={(e) => setCpf(e.target.value)}>
        {clientes.map((cliente, index) => {
          return <option value={cliente.cpf}>{cliente.nome}</option>
        })}
      </select>
    </p>
    <button onClick={cadastrar}>Cadastrar</button>
  </>
}
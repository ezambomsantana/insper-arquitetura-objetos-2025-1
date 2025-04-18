import { useEffect, useState } from "react"


export function ClienteTable() {


    const [clientes, setClientes] = useState([])


    {
        'numeroConta' numeroConta,
        'principal': {
            'cpf': cpf
        }
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


    return <table>

        <tbody>
            {clientes.map((cliente, index) => {
            return <tr key={index}>
                <td>{cliente.nome}</td>
                <td>{cliente.cpf}</td>
                </tr>
            })}
        </tbody>
    </table>


}
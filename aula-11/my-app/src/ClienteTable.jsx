import { DataGrid } from "@mui/x-data-grid"
import { useEffect, useState } from "react"


export function ClienteTable() {

    const [clientes, setClientes] = useState([])
    useEffect(() => {

        fetch('http://localhost:8080/cliente', {
            method: 'GET'
        }).then(response => {
            return response.json()
        }).then(data => {
            setClientes(data.content)
        })

    }, [])

    const columns = [
        { field: 'nome', headerName: 'Nome', width: 90 },
        { field: 'cpf', headerName: 'CPF', width: 90 },
        { field: 'dataNascimento', headerName: 'Data de Nascimento', width: 90 }
    ]


    return <>
        <DataGrid
            rows={clientes}
            columns={columns}
            initialState={{
                pagination: {
                    paginationModel: {
                    pageSize: 10,
                    },
                },
            }}
            pageSizeOptions={[5]}
            checkboxSelection
            disableRowSelectionOnClick
        />

    </>


}
import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material";

export default function CustomTableComponent({ columns, rows }:{ columns: string[], rows: Object[] }) {

    return (
        <TableContainer component={Paper} sx={{
            minWidth: "100%"
        }}>
            <Table>
                <TableHead>
                    <TableRow>
                        {
                            columns.map(value => {
                                return (
                                    <TableCell>{value}</TableCell>
                                )
                            })
                        }
                    </TableRow>
                </TableHead>

                <TableBody>
                    {
                        rows.map(row => {
                            let dataRow = [];

                            for (let index = 0; index < columns.length; index++) {
                                dataRow.push(row[columns[index]])
                            }

                            return (
                                <TableRow>
                                    {dataRow.map((value, idx) => (
                                        <TableCell key={idx}>{value}</TableCell>
                                    ))}
                                </TableRow>
                            );
                        })
                    }
                </TableBody>
            </Table>
        </TableContainer>
    )
}
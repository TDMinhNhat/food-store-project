import { Box, List, ListItemButton, ListItemIcon, ListItemText, Stack } from "@mui/material";
import BarChartIcon from '@mui/icons-material/BarChart';
import CategoryIcon from '@mui/icons-material/Category';

export default function TabAdminComponent({ tab, setTab }:{ tab: string, setTab: (tab: string) => void }) {

    function handleChangeTag(tab: string): void {
        setTab(tab);
    }
    
    function getCSSSelected(tabMenu: string): object {
        return {
            backgroundColor: tab === tabMenu ? "blue" : "transparent",
            color: tab === tabMenu ? "white" : "black",
        }
    }

    return (
        <Stack direction={"column"} sx={{
            borderRight: "1px solid #e0e0e0",
            position: "fixed",
            top: 0,
            left: 0,
            height: "100vh",
            width: "200px",
            backgroundColor: "white",
            boxShadow: "0 0 10px 0 rgba(0, 0, 0, 0.1)"
        }}>
            <Box>
                
            </Box>

            <Stack direction={"column"}>
                <List>

                    {/* Dashboard */}
                    <ListItemButton onClick={() => handleChangeTag("Dashboard")} sx={getCSSSelected("Dashboard")}>
                        <ListItemIcon>
                            <BarChartIcon />
                        </ListItemIcon>
                        <ListItemText primary="Dashboard"/>
                    </ListItemButton>

                    {/* Category */}
                    <ListItemButton onClick={() => handleChangeTag("Category")} sx={getCSSSelected("Category")}>
                        <ListItemIcon>
                            <CategoryIcon />
                        </ListItemIcon>
                        <ListItemText primary="Category"/>
                    </ListItemButton>

                </List>
            </Stack>

            <Box>

            </Box>
        </Stack>
    )
}
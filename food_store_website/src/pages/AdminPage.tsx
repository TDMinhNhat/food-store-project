import { Box, Stack } from "@mui/material";
import { useState } from "react";
import TabAdminComponent from "../components/admin/TabAdminComponent";
import DashboardComponent from "../components/admin/DashboardComponent";
import CategoryComponent from "../components/admin/CategoryComponent";

export default function AdminPage() {

    const [tab, setTab] = useState("Dashboard");
    
    function getContentTab(tab: string) {
        switch(tab) {
            case "Dashboard":
                return <DashboardComponent />;
            case "Category":
                return <CategoryComponent />;
            default:
                return <DashboardComponent />;
        }
    }

    return (
        <Stack direction={"row"}>
            <TabAdminComponent tab={tab} setTab={setTab} />

            <Box sx={{
                marginLeft: "200px"
            }}>
                { getContentTab(tab) }
            </Box>

        </Stack>
    )
}
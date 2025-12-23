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
        <Stack direction={"row"} sx={{
            width: "100%",
            height: "100%",
        }}>
            <TabAdminComponent tab={tab} setTab={setTab} />

            <Box sx={{
                width: "100%",
                marginLeft: "200px"
            }}>
                { getContentTab(tab) }
            </Box>

        </Stack>
    )
}
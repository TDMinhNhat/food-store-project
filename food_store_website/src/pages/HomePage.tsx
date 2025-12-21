import { useState } from "react";

export default function HomePage() {

    const [tab, setTab] = useState("Dashboard");
    const [menu, setMenu] = useState(null);

    return (
        <h1>Home Page</h1>
    )
}
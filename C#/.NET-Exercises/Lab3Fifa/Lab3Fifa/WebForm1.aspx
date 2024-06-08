<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Lab3Fifa.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Fifa 2022</h1>
            <asp:DropDownList ID="lstStadiumNames" runat="server" AutoPostBack="True" OnSelectedIndexChanged="lstTeamNames_SelectedIndexChanged"></asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="lblStadiumName" runat="server" Visible="False"></asp:Label>
            &nbsp;
            <asp:Label ID="lblStadiumCity" runat="server" Visible="False"></asp:Label>
            &nbsp;
            <asp:Label ID="lblStadiumCapacity" runat="server" Visible="False"></asp:Label>
            <br />
            <br />
            <asp:HyperLink ID="googleMapsLink" runat="server" Visible="False">[googleMapsLink]</asp:HyperLink>
            <br />
            <br />
            <asp:HyperLink ID="wikipediaLink" runat="server" Visible="False">[wikipediaLink]</asp:HyperLink>
            <br />
            <br />
            <asp:PlaceHolder ID="iframePH" runat="server"></asp:PlaceHolder>
            <br />
            
        </div>
    </form>
</body>
</html>

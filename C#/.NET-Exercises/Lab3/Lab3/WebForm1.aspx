<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Lab3.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Fifa 2022</h1>

            <br />
            <asp:DropDownList ID="lstTeamNames" runat="server" AutoPostBack="True" OnSelectedIndexChanged="lstTeamNames_SelectedIndexChanged">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="lblPlayers" runat="server" Text="Selected Team Players" Visible="False"></asp:Label>
&nbsp;<asp:Label ID="lblSumPlayers" runat="server" Visible="False"></asp:Label>
            <br />
            <asp:DropDownList ID="lstTeamPlayers" runat="server" AutoPostBack="True" Visible="False">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="lblPlayersNS" runat="server" Text="Non Selected Players" Visible="False"></asp:Label>
&nbsp;<asp:Label ID="lblSumPlayersNS" runat="server" Visible="False"></asp:Label>
            <br />
            <asp:DropDownList ID="lstTeamPlayersNS" runat="server" Visible="False">
            </asp:DropDownList>
            <br />
            <br />

        </div>
    </form>
</body>
</html>

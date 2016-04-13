package br.univali.ps.ui.rstautil.tree.filters;

import static br.univali.ps.ui.rstautil.tree.filters.SymbolTypeFilter.*;

/**
 *
 * @author Luiz Fernando Noschang
 */
public interface SymbolTypeFilterListener
{
    public void symbolTypeAccepted(SymbolType symbolType);
    
    public void symbolTypeRejected(SymbolType symbolType);
    
    public void constantsAccepted();
    
    public void constantsRejected();
    
    public void variablesAccepted();
    
    public void variablesRejected();
}
